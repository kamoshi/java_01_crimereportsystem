package com.guides.crimereportsystem.service;

import com.guides.crimereportsystem.entity.Responder;

import java.util.List;

public interface ResponderService {
    List<Responder> getAllResponders();
    Responder saveResponder(Responder responder);
    Responder getResponderById(Long id);
    Responder updateResponder(Responder responder);
    void deleteResponderById(Long id);
}
