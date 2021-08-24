/*
 * Copyright (c) 2019 Automation Anywhere.
 * All rights reserved.
 *
 * This software is the proprietary information of Automation Anywhere.
 * You shall use it only in accordance with the terms of the license agreement
 * you entered into with Automation Anywhere.
 */
/**
 *
 */
package com.automationanywhere.botcommand.samples.commands.basic;

import com.automationanywhere.botcommand.data.Value;
import com.automationanywhere.botcommand.data.impl.StringValue;
import com.automationanywhere.botcommand.exception.BotCommandException;
import com.automationanywhere.commandsdk.annotations.BotCommand;
import com.automationanywhere.commandsdk.annotations.CommandPkg;
import com.automationanywhere.commandsdk.annotations.Execute;
import com.automationanywhere.commandsdk.annotations.Idx;
import com.automationanywhere.commandsdk.annotations.Pkg;
import com.automationanywhere.commandsdk.annotations.rules.NotEmpty;
import com.automationanywhere.commandsdk.i18n.Messages;
import com.automationanywhere.commandsdk.i18n.MessagesFactory;

import static com.automationanywhere.commandsdk.model.AttributeType.TEXT;
import static com.automationanywhere.commandsdk.model.DataType.STRING;

@BotCommand


@CommandPkg(

		//Nome da action
		name = "concatenate",
		//  Nome da action
		label = "concatenate",
		//É o nome que vai aparecer no placeholder
		node_label = "concatenando {{firstString}} e {{secondString}} e atribuindo a {{returnTo}}",
		description = "Essa Action concatena duas Strings",
		icon = "pkg.svg",
		return_type = STRING,
		return_required = true
)

public class Concatenate {

	@Execute
	public Value<String> action(
			@Idx(index = "1", type = TEXT)
			@Pkg(label = "[[Concatenate.firstString.label]]")
			@NotEmpty 
			String firstString,
			
			@Idx(index = "2", type = TEXT) 
			@Pkg(label = "[[Concatenate.secondString.label]]") 
			@NotEmpty 
			String secondString
	) {

		if (""==firstString.trim())
			throw new BotCommandException("Primeira string está vazia");

		if ("".equals(secondString.trim()))
			throw new BotCommandException("Segunda String  está vazia");

		String result = firstString + secondString;

		return new StringValue(result);
	}
}
