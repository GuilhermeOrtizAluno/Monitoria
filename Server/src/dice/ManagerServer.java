package dice;

import static app.Program.*;
import entities.Route;
import entities.User;
import com.google.gson.Gson;
import crud.MonitoringDAO;
import crud.ScheduleDAO;
import crud.StudentDAO;
import crud.UserDAO;
import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.json.JSONException;
import org.json.JSONObject;
import static dice.TCPServer.listPw;
import static dice.TCPServer.usuariosAtivos;
import entities.Monitoring;
import entities.Schedule;
import entities.Student;
import java.awt.Color;
import java.sql.SQLException;
import org.json.JSONArray;

/**
 * Gerenciador do Servidor
 *
 * @author Guilherme Ortiz
 *
 * Consumir Json Tomar Desição Retorna Json
 */
public class ManagerServer extends Thread {

    private InputStreamReader in;
    private BufferedReader bf;
    private PrintWriter pr;
    private final Socket clientSocket;
    private User user;
    private Color legend;

    public ManagerServer(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    public void Connection() {
        try {
            in = new InputStreamReader(clientSocket.getInputStream());
            bf = new BufferedReader(in);
            pr = new PrintWriter(clientSocket.getOutputStream());
            listPw.add(pr);

            this.start();
        } catch (IOException e) {
            System.out.println("Connection:" + e.getMessage());
        }
    }

    @Override
    public void run() {
        try { // an echo server
            while (true) {

                //Read String
                String sRoute = bf.readLine();

                // Color legend show logs
                legend = Color.GREEN;

                // Convert Json String to Route Object
                Gson gson = new Gson();
                Route rRoute = gson.fromJson(sRoute, Route.class);

                if (rRoute == null) {
                    System.out.println("Erro grave: " + sRoute);
                    return;
                }
                // <editor-fold defaultstate="collapsed" desc="Cases">
                switch (rRoute.getRota()) {
                    //Login
                    case "login.login" -> {
                        //Shows what came
                        showReceived(sRoute);

                        login(sRoute);
                    }
                    case "login.logout" -> {
                        //Shows what came
                        showReceived(sRoute);

                        logout();
                    }
                    case "login.registro" -> {
                        //Shows what came
                        showReceived(sRoute);

                        register(sRoute);
                    }
                    case "login.update" -> {
                        //Shows what came
                        showReceived(sRoute);

                        update(sRoute);
                    }
                    //Users
                    case "usuario.delete" -> {
                        //Shows what came
                        showReceived(sRoute);

                        delete(sRoute);
                    }
                    //mensagem
                    case "mensagem.mensagem" -> {
                        //Shows what came
                        showReceived(sRoute);

                        mensagem();
                    }
                    //Client
                    case "cliente.usuarios-ativos" -> {
                        //Shows what came
                        showReceived(sRoute);

                        //usersOn();
                        //monitores();
                    }
                    case "cliente.usuarios" -> {
                        //Shows what came
                        showReceived(sRoute);

                        usersAll();
                    }
                    // Monitoring
                    case "monitoria.registro" -> {
                        showReceived(sRoute);

                        registerdaoMonitoring(sRoute);
                    }
                    case "monitoria.update" -> {
                        showReceived(sRoute);

                        updateMonitoring(sRoute);
                    }
                    case "monitoria.listar" -> {
                        showReceived(sRoute);

                        monitorings();
                    }
                    case "monitoria.listar-monitor" -> {
                        showReceived(sRoute);

                        monitors(sRoute);
                    }
                    case "monitoria.listar-aluno" -> {
                        showReceived(sRoute);

                        students(sRoute);
                    }
                    case "monitoria.delete" -> {
                        showReceived(sRoute);
                        deleteMonitoring(sRoute);
                    }
                    //Student
                    case "aluno-monitoria.inscrever" -> {
                        showReceived(sRoute);
                        studentRegister(sRoute);
                    }
                    case "aluno-monitoria.delete" -> {
                        showReceived(sRoute);
                        studentDelete(sRoute);
                    }
                    default -> {
                        legend = Color.RED;
                        //Shows what came
                        showReceived(sRoute);

                        errorRoute();
                    }
                }// </editor-fold>  
            }
        } catch (EOFException e) {
            System.out.println("EOF:" + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO:" + e.getMessage());
        } catch (JSONException ex) {
            Logger.getLogger(ManagerServer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManagerServer.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                removeUserOn(user.getUsuario());
                clientSocket.close();
            } catch (IOException e) {
                /*close failed*/
            } catch (JSONException ex) {
                Logger.getLogger(ManagerServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Functions">

    //FINALIZADO - LOGIN DOS 3 USUARIOS
    private void login(String string) throws IOException, JSONException {
        Gson gson = new Gson();
        UserDAO dUser = new UserDAO();

        // Convert Json String to User Object
        user = gson.fromJson(string, User.class);

        // Search for user in the bank
        user = dUser.search(user);

        boolean bUser = user.getUsuario() != null;

        JSONObject route = new JSONObject();
        JSONObject joUser = new JSONObject();
        route.put("rota", "login.login");

        // Valid user
        if (!bUser) {
            legend = Color.ORANGE;
            route.put("erro", "Usuario ou Senha invalido");
        } else {
            legend = Color.BLACK;

            String sTypeUser = user.isIs_admin() ? "admin" : user.isIs_monitor() ? "monitor" : "aluno";
            route.put("erro", "false");
            route.put("tipo_usuario", sTypeUser);

            joUser.put("usuario", user.getUsuario());
            joUser.put("nome", user.getNome());
            joUser.put("tipo_usuario", sTypeUser);
            usuariosAtivos.put(joUser);

            // show client on
            usersController.includeClient(user.getUsuario());
        }

        //Send User
        String str = gson.toJson(user);

        // Shows what will be sent
        showSend(route.toString());
        // Send
        pr.println(route);
        pr.flush();

        if (bUser) {
            usersOn();
        }
    }

    //FINALIZADO - LOGOUT DOS 3 USUARIOS
    private void logout() throws IOException, JSONException {
        JSONObject route = new JSONObject();
        route.put("rota", "login.logout");
        route.put("erro", "false");

        legend = Color.BLACK;

        // Shows what will be sent
        showSend(route.toString());

        removeUserOn(user.getUsuario());

        user = null;//pode dar ruim

        // Send
        pr.println(route);
        pr.flush();
    }

    //FINALIZADO - REGISTRO DE MONITOR E ALUNO
    private void register(String string) throws IOException, JSONException {
        Gson gson = new Gson();
        UserDAO dUser = new UserDAO();

        // Convert Json String to User Object
        user = gson.fromJson(string, User.class);

        JSONObject route = new JSONObject();
        route.put("rota", "login.registro");

        // Create User in the bank
        boolean bUser = dUser.create(user);

        if (!bUser) {
            legend = Color.ORANGE;
            route.put("erro", "Cadastro não efetuado!");
        } else {
            legend = Color.BLACK;
            route.put("erro", "false");
        }

        // Shows what will be sent
        showSend(route.toString());
        // Send
        pr.println(route);
        pr.flush();
        //pr.close();
    }

    //SEMI-FINALIZADO - ATUALIZAR DADOS DE MONITOR E ALUNO (FALTA AS CONSIDERAR QUANDO NÃO VEM TODOS OS DADOS), FALTA ALTERAR AS RELAÇOES Q DEPENDEM DOS DOIS
    private void update(String string) throws IOException, JSONException {
        Gson gson = new Gson();
        UserDAO dUser = new UserDAO();
        User rUser = gson.fromJson(string, User.class);

        user.setSenha(rUser.getSenha());
        user.setNome(rUser.getNome());
        user.setUsuario(rUser.getUsuario());
        user.setNovo_usuario(rUser.getNovo_usuario());

        // Search for user in the bank
        boolean bUser = dUser.update(rUser);

        JSONObject route = new JSONObject();
        route.put("rota", "login.update");

        // Valid user
        if (!bUser) {
            legend = Color.ORANGE;
            route.put("erro", "Alteração nao realizada");
        } else {
            removeUserOn(user.getUsuario());
            legend = Color.BLACK;
            route.put("erro", "false");
        }

        // Shows what will be sent
        showSend(route.toString());

        // Send
        pr.println(route);
        pr.flush();
        //pr.close();
    }

    //SEMI-FINALIZADO - DELETAR ALUNO E MONITOR - FALTA APAGAR AS RELAÇÕES QUE DEPENDEM DOS DOIS
    private void delete(String string) throws IOException, JSONException {
        UserDAO dUser = new UserDAO();
        User userD = new Gson().fromJson(string, User.class);
        boolean bUser;

        if (user.isIs_admin()) {
            bUser = dUser.delete(userD);
        } else {
            bUser = dUser.delete(user);
        }

        JSONObject route = new JSONObject();
        route.put("rota", "usuario.delete");

        // Valid user
        if (!bUser) {
            legend = Color.ORANGE;
            route.put("erro", "Usuario nao deletado");
        } else {
            legend = Color.BLACK;
            route.put("erro", "false");

            if (user.isIs_admin()) {
                removeUserOn(userD.getUsuario());
            } else {
                removeUserOn(user.getUsuario());
            }
            //user = null;
        }

        // Shows what will be sent
        showSend(route.toString());
        // Send
        pr.println(route);
        pr.flush();

        //pr.close();
    }

    //FINALIZADO - REMOVE USUARIO LOGADO
    private void removeUserOn(String usuarioRemove) throws JSONException, IOException {
        int i = 0, j = 0;

        for (; i < usuariosAtivos.length(); i++) {
            if (usuarioRemove.equals(usuariosAtivos.getJSONObject(i).getString("usuario"))) {
                j = 1;
                break;
            }
        }
        if (j == 1) {
            usuariosAtivos.remove(i);
        }
        usersOn();
    }

    //NÃO MEXI
    private void mensagem() {

    }

    //NÃO MEXI
    private void errorRoute() throws JSONException, IOException {
        JOptionPane.showMessageDialog(
                null,
                "No route found",
                "Route error",
                JOptionPane.ERROR_MESSAGE
        );
        JSONObject route = new JSONObject();
        route.put("rota", "erro");
        route.put("erro", "mesagem_fora_do_padrao");
        // Shows what will be sent
        showSend(route.toString());
        // Send
        pr.println(route);
        pr.flush();

    }

    //FINALIZADO - CADASTRA A MONITORIA C0M HORARIO
    private void registerdaoMonitoring(String sMonitoring) throws JSONException, IOException {
        Gson gson = new Gson();
        MonitoringDAO daoMonitoring = new MonitoringDAO();

        // Convert Json String to Monitoring Object
        Monitoring monitoria = gson.fromJson(sMonitoring, Monitoring.class);

        boolean bMonitoring = daoMonitoring.create(monitoria);

        JSONObject route = new JSONObject();
        route.put("rota", "monitoria.registro");

        ScheduleDAO sDao = new ScheduleDAO();
        Schedule horario = gson.fromJson(sMonitoring, Schedule.class);
        boolean bHora = false;
        
        String[] horarios = horario.getHorarios();

        if (bHora == true) {
            for (String hor : horarios) {
                bHora = sDao.create(hor, Integer.parseInt(monitoria.getId()));
                if (!bHora) {
                    route.put("erro", "Erro ao salvar horário");
                }
            }
        }

        if (!bMonitoring) {
            legend = Color.RED;
            route.put("erro", "Algo deu errado");
        } else {
            legend = Color.BLACK;
            route.put("erro", "false");
            //route.put("monitores", monitores);
        }

        // Shows what will be sent
        showSend(route.toString());

        // Send
        pr.println(route);
        pr.flush();
    }

    //SEMI-FINALIZADO - ALTERA DADOS DA MONITORIA (FALTA CONSIDERAR QUANDO VEM SÓ 1 OU 2 DADOS)
    private void updateMonitoring(String sMonitoring) throws JSONException, IOException {
        Gson gson = new Gson();
        MonitoringDAO daoMonitoring = new MonitoringDAO();

        // Convert Json String to Monitoring Object
        var monitoria = gson.fromJson(sMonitoring, Monitoring.class);

        boolean bMonitoring = daoMonitoring.update(monitoria);

        ScheduleDAO sDao = new ScheduleDAO();

        Schedule horario = gson.fromJson(sMonitoring, Schedule.class);

        boolean bHora = sDao.delete(Integer.parseInt(monitoria.getId()));

        JSONObject route = new JSONObject();
        route.put("rota", "monitoria.update");

        String[] horarios = horario.getHorarios();

        if (bHora == true) {
            for (String hor : horarios) {
                bHora = sDao.create(hor, Integer.parseInt(monitoria.getId()));
                if (!bHora) {
                    route.put("erro", "Erro ao salvar horário");
                }
            }
        }

        if (!bMonitoring) {
            legend = Color.RED;
            route.put("erro", "Algo deu errado");
        } else {
            legend = Color.BLACK;
            route.put("erro", "false");
            //route.put("monitores", monitores);
        }

        // Shows what will be sent
        showSend(route.toString());
        // Send
        pr.println(route);
        pr.flush();
    }

    //FINALIZADO - LISTAR MONITORIAS COM HORARIOS E ALUNOS
    private void monitorings() throws JSONException, IOException {
        MonitoringDAO daoMonitoring = new MonitoringDAO();

        JSONArray monitorings = daoMonitoring.read();

        boolean bMonitoring = monitorings != null;

        JSONObject route = new JSONObject();
        route.put("rota", "monitoria.listar");

        if (!bMonitoring) {
            legend = Color.RED;
            route.put("erro", "Algo deu errado");
        } else {
            legend = Color.BLACK;
            route.put("erro", "false");
            route.put("monitorias", monitorings);
        }

        // Shows what will be sent
        showSend(route.toString());

        // Send
        pr.println(route);
        pr.flush();
    }

    //FINALIZADO - DELETAR MONITORIA 
    private void deleteMonitoring(String sMonitoring) throws JSONException, IOException {
        MonitoringDAO daoMonitoring = new MonitoringDAO();
        Monitoring monitoring = new Gson().fromJson(sMonitoring, Monitoring.class);
        boolean bMonitoring;

        bMonitoring = daoMonitoring.delete(monitoring);

        JSONObject route = new JSONObject();
        route.put("rota", "monitoria.delete");

        // Valid user
        if (!bMonitoring) {
            legend = Color.ORANGE;
            route.put("erro", "Usuario nao deletado");
        } else {
            legend = Color.BLACK;
            route.put("erro", "false");
        }

        // Shows what will be sent
        showSend(route.toString());
        // Send
        pr.println(route);
        pr.flush();

    }

    //FINALIZADO - LISTAR MONITORIAS DO MONITOR
    private void monitors(String string) throws JSONException, IOException {
        MonitoringDAO daoMonitoring = new MonitoringDAO();
        Gson gson = new Gson();

        JSONArray monitorings = daoMonitoring.read();

        Monitoring monitoring = gson.fromJson(string, Monitoring.class);

        JSONArray monitoriasMonitor = monitoriasMonitor(monitorings, monitoring.getUsuario_monitor());

        JSONObject route = new JSONObject();
        route.put("rota", "monitoria.listar-monitor");

        route.put("erro", "false");
        route.put("monitorias", monitoriasMonitor);

        // Shows what will be sent
        showSend(route.toString());

        // Send
        pr.println(route);
        pr.flush();

    }

    //FINALIZADO - FILTRA MONITORIAS DO MONITOR
    private JSONArray monitoriasMonitor(JSONArray monitorings, String usuario_monitor) throws JSONException {
        JSONArray monitoriasMonitor = new JSONArray();

        for (int i = 0; i < monitorings.length(); i++) {
            JSONObject monitoria = monitorings.getJSONObject(i);

            if (monitoria.getString("usuario_monitor").equals(usuario_monitor)) {
                monitoriasMonitor.put(monitoria);
            }
        }

        return monitoriasMonitor;
    }

    //FINALIZADO - LISTAR ALUNOS NA MONITORIA
    private void students(String string) throws JSONException, IOException {
        MonitoringDAO daoMonitoring = new MonitoringDAO();
        Gson gson = new Gson();

        JSONArray monitorings = daoMonitoring.read();

        Monitoring monitoring = gson.fromJson(string, Monitoring.class);
        JSONArray monitoriasAlunos = null;

        if (monitoring != null) {
            monitoriasAlunos = monitoriasAluno(monitorings, monitoring.getUsuario_aluno());
        }

        JSONObject route = new JSONObject();
        route.put("rota", "monitoria.listar-aluno");

        route.put("erro", "false");
        route.put("monitorias", monitoriasAlunos);

        // Shows what will be sent
        showSend(route.toString());

        // Send
        pr.println(route);
        pr.flush();
    }

    //FINALIZADO - FILTRA MONITORIAS DO MONITOR
    private JSONArray monitoriasAluno(JSONArray monitorings, String usuario_aluno) throws JSONException {
        JSONArray monitoriasAluno = new JSONArray();

        for (int i = 0; i < monitorings.length(); i++) {
            JSONObject monitoriaAluno = monitorings.getJSONObject(i);
            JSONArray alunos = monitoriaAluno.getJSONArray("alunos");

            for (int j = 0; j < alunos.length(); j++) {
                JSONObject aluno = alunos.getJSONObject(j);
                if (aluno.getString("usuario").equals(usuario_aluno)) {
                    monitoriasAluno.put(monitoriaAluno);
                    break;
                }
            }
        }
        return monitoriasAluno;
    }

    //FINALIZADO - REGISTRAR ALUNO NA MONITORIA
    private void studentRegister(String sMonitoring) throws JSONException, SQLException, IOException {
        Gson gson = new Gson();
        MonitoringDAO daoMonitoring = new MonitoringDAO();

        // Convert Json String to Monitoring Object
        Monitoring monitoria = gson.fromJson(sMonitoring, Monitoring.class);

        boolean bMonitoring = daoMonitoring.search(monitoria);

        JSONObject route = new JSONObject();
        route.put("rota", "aluno-monitoria.inscrever");

        if (bMonitoring) {
            StudentDAO sDao = new StudentDAO();
            Student student = gson.fromJson(sMonitoring, Student.class);

            if (sDao.create(student)) {
                route.put("erro", "false");
            } else {
                route.put("erro", "Erro ao inscrever aluno");
            }
        } else {
            route.put("erro", "Erro ao inscrever aluno");
        }

        // Shows what will be sent
        showSend(route.toString());

        // Send
        pr.println(route);
        pr.flush();
    }

    //TERMINANDO - REMOVER ALUNO DA MONITORIA
    private void studentDelete(String string) throws JSONException, IOException {
        Gson gson = new Gson();

        JSONObject route = new JSONObject();
        route.put("rota", "aluno-monitoria.delete");

        StudentDAO sDao = new StudentDAO();
        Student student = gson.fromJson(string, Student.class);

        if (sDao.delete(student)) {
            route.put("erro", "false");
        } else {
            route.put("erro", "Erro ao inscrever aluno");
        }

        // Shows what will be sent
        showSend(route.toString());

        // Send
        pr.println(route);
        pr.flush();
    }

    //FINALIZADO - LISTAR TODOS OS USUARIOS
    private void usersAll() throws JSONException, IOException {
        UserDAO dUser = new UserDAO();

        // Search for user in the bank
        var users = dUser.read();

        boolean bUser = users != null;

        JSONObject route = new JSONObject();
        route.put("rota", "cliente.usuarios");

        // Valid user
        if (!bUser) {
            legend = Color.ORANGE;
            route.put("erro", "Nenhum usuario encontrado");
            showSend(route.toString());
        } else {
            legend = Color.BLACK;
            route.put("erro", "false");
            route.put("usuarios", users);
            serverController.includeLogUsers(route, false);
            System.out.println("Send -> " + route);
        }

        // Send
        pr.println(route);
        pr.flush();
    }

    //FINALIZADO - LISTAR TODOS OS USUARIOS LOGADOS
    private void usersOn() throws JSONException, IOException {
        JSONObject route = new JSONObject();
        route.put("rota", "cliente.usuarios-ativos");
        route.put("usuarios", usuariosAtivos);

        System.out.println("Send -> " + route);

        //Iterface Log
        serverController.includeLogUsers(route, true);

        for (PrintWriter pw : listPw) {
            pw.println(route);
            pw.flush();
        }
    }

    //FINALIZADO - MOSTRAR CONTEUDO ENVIADO
    private void showSend(String send) throws IOException {
        //Terminal
        System.out.println("Send -> " + send);

        //Iterface Log
        serverController.includeLog("Send -> " + send, legend, Color.BLUE);

        //Log txt
        File fLog = new File("log.txt");
        try (FileWriter fwLog = new FileWriter(fLog, true)) {
            fwLog.write("Send -> " + send + "\n");
            fwLog.flush();
        }
    }

    //FINALIZADO - MOSTRAR CONTEUDO RECEBIDO
    private void showReceived(String received) throws IOException {
        //Terminal
        System.out.println("Received <- " + received);

        //Iterface Log
        serverController.includeLog("Received <- " + received, legend, Color.cyan);

        //Log txt
        File fLog = new File("log.txt");
        try (FileWriter fwLog = new FileWriter(fLog, true)) {
            fwLog.write("Received <- " + received + "\n");
            fwLog.flush();
        }
    }

    // </editor-fold>  
}
