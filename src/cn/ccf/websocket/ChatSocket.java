package cn.ccf.websocket;

import cn.ccf.pojo.ContentVo;
import cn.ccf.pojo.Message;
import com.alibaba.fastjson.JSON;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;


/**
 * @ServerEndpoint 注解是一个类层次的注解，它的功能主要是将目前的类定义成一个websocket服务器端,
 * 注解的值将被用于监听用户连接的终端访问URL地址,客户端可以通过这个URL来连接到WebSocket服务器端
 * @author uptop
 */
@ServerEndpoint("/chatSocket")
public class ChatSocket {

    private String username;
    private static List<Session> sessions = new ArrayList<Session>();
    private static List<String> usernames = new ArrayList<String>();
    private static Map<String , Session> map = new HashMap<String, Session>();
    /**
     * 连接建立成功调用的方法
     *
     * @param session 可选的参数。session为与某个客户端的连接会话，需要通过它来给客户端发送数据
     */
    @OnOpen
    public void open(Session session) {
        String queryString = session.getQueryString();
        username = queryString.split("=")[1];
        System.out.println(queryString);

        usernames.add((this.username));
        sessions.add(session);
        map.put(username, session);

        String msg = "欢迎"+this.username+"进入聊天室！！";

        Message message = new Message();
        message.setWelcome(msg);
        message.setUsers(usernames);

        this.broacast(sessions, message.toJson());
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void close(Session session) {
        sessions.remove(session);
        usernames.remove(this.username);
        String msg = "欢送"+this.username+"离开聊天室！！";

        Message message = new Message();
        message.setWelcome(msg);
        message.setUsers(usernames);

        this.broacast(sessions, message.toJson());
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param session 可选的参数
     */
    @OnMessage
    public void message(Session session, String msg) {

        System.out.println(msg);
        ContentVo contentVo = JSON.parseObject(msg, ContentVo.class);

        if (contentVo.getType() == 1) {
            //广播
            Message message = new Message();
            if (contentVo.getIsPlotting() == 1) {
                message.setPlotting(1);
                message.setContent(this.username, contentVo.getMsg(), 1);
            } else {
                message.setContent(this.username, contentVo.getMsg(), 0);
            }

            this.broacast(sessions, message.toJson());
        } else {
            //单聊
            String to = contentVo.getTo();
            Session to_session = map.get(to);

            Message message = new Message();
            message.setContent(this.username, contentVo.getMsg(), 1);

            try {
                to_session.getBasicRemote().sendText(message.toJson());
                //发给你自己的消息
                session.getBasicRemote().sendText(message.toJson());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void broacast(List<Session> sessions, String msg) {
        for (Session session : sessions) {
            try {
                session.getBasicRemote().sendText(msg);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    /**
     * 发生错误时调用
     *
     * @param error 错误信息
     */
    @OnError
    public void onError(Throwable error) {
        System.out.println("发生错误");
        error.printStackTrace();
    }

}
