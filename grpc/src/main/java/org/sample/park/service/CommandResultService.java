package org.sample.park.service;

import org.sample.park.model.CommandResult;
import org.sample.park.repository.CommandResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommandResultService {

    @Autowired
    private CommandResultRepository repository;

    public CommandResult saveResult(String result) {
        CommandResult commandResult = new CommandResult(result);
        return repository.save(commandResult);
    }
}
