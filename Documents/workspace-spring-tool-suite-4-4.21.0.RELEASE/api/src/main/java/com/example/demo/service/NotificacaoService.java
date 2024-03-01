package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.corundumstudio.socketio.SocketIONamespace;
import com.corundumstudio.socketio.SocketIOServer;

import javax.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class NotificacaoService {
	
	private final SocketIONamespace namespace;

    private final SocketIOServer server;

    private static final String NOTIFICATION_EVENT = "notificacao";

    public void publicar(String notificacao) {
        //log.info("Envio de notificação: {}", notificacao.toString());
        namespace.getBroadcastOperations().sendEvent("notificacao", notificacao);
    }

    public NotificacaoService(SocketIOServer server) {
        this.server = server;

        this.namespace = server.addNamespace("/ws-listener");

        this.server.start();
    }

    @PreDestroy
    private void stopSocketIO() {
        this.server.stop();
    }
}
