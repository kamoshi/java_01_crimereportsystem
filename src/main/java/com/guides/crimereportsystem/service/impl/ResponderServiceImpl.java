package com.guides.crimereportsystem.service.impl;

import com.guides.crimereportsystem.entity.Responder;
import com.guides.crimereportsystem.repository.ResponderRepository;
import com.guides.crimereportsystem.service.ResponderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResponderServiceImpl implements ResponderService {
    private final ResponderRepository responderRepository;

    public ResponderServiceImpl(ResponderRepository responderRepository) {
        super();
        this.responderRepository = responderRepository;
    }

    @Override
    public List<Responder> getAllResponders() {
        return this.responderRepository.findAll();
    }

    @Override
    public Responder saveResponder(Responder responder) {
        return this.responderRepository.save(responder);
    }

    @Override
    public Responder getResponderById(Long id) {
        return this.responderRepository.findById(id).get();
    }

    @Override
    public Responder updateResponder(Responder responder) {
        return this.responderRepository.save(responder);
    }

    @Override
    public void deleteResponderById(Long id) {
        this.responderRepository.deleteById(id);
    }
}
