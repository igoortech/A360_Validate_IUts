/*
 * Copyright (c) 2020 Automation Anywhere.
 * All rights reserved.
 *
 * This software is the proprietary information of Automation Anywhere.
 * You shall use it only in accordance with the terms of the license agreement
 * you entered into with Automation Anywhere.
 */

/**
 *
 */
package com.automationanywhere.botcommand.samples.conditional;

import static com.automationanywhere.commandsdk.annotations.BotCommand.CommandType.Condition;
import static com.automationanywhere.commandsdk.model.DataType.BOOLEAN;
import static com.automationanywhere.commandsdk.model.DataType.STRING;

import com.automationanywhere.commandsdk.annotations.BotCommand;
import com.automationanywhere.commandsdk.annotations.CommandPkg;
import com.automationanywhere.commandsdk.annotations.ConditionTest;
import com.automationanywhere.commandsdk.annotations.Idx;
import com.automationanywhere.commandsdk.annotations.Pkg;
import com.automationanywhere.commandsdk.annotations.rules.NotEmpty;
import com.automationanywhere.commandsdk.annotations.rules.VariableType;
import com.automationanywhere.commandsdk.model.AttributeType;


@BotCommand(commandType = Condition)
@CommandPkg(
        label = "EmailValidate",
        name = "EmailValidate",
        node_label = "validando email {{email}}",
        description = "Valida se o email é válido"
)
public class EmailValidate {

    @ConditionTest
    public Boolean validate(
            @Idx(index = "1", type = AttributeType.TEXT)
            @VariableType(STRING)
            @Pkg(label = "Email:")
            @NotEmpty String email
    ) {

       if(email.trim().equals("")){
           return false;
       }
       return email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}");
    }

}
