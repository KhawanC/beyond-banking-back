package com.kaua.hruser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.kaua.hruser.enums.RoleEnum;
import com.kaua.hruser.service.RoleService;

@Component   
public class CommandsStartUp implements CommandLineRunner{
    
    @Autowired
    RoleService roleService;

    @Override
    public void run(String... args) throws Exception {
        if(roleService.findByName(RoleEnum.ROLE_ADMIN).isEmpty())
            roleService.save(RoleEnum.ROLE_ADMIN);
        if(roleService.findByName(RoleEnum.ROLE_ESTUDANTE).isEmpty())
            roleService.save(RoleEnum.ROLE_ESTUDANTE);
        if(roleService.findByName(RoleEnum.ROLE_RESPONSAVEL).isEmpty())
        	roleService.save(RoleEnum.ROLE_RESPONSAVEL);
        if(roleService.findByName(RoleEnum.ROLE_INSTITUICAO).isEmpty())
        	roleService.save(RoleEnum.ROLE_INSTITUICAO);
    }
}
