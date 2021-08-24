package com.automationanywhere.botcommand.samples.commands.basic.types;

import com.automationanywhere.bot.service.GlobalSessionContext;
import com.automationanywhere.botcommand.BotCommand;
import com.automationanywhere.botcommand.data.Value;
import com.automationanywhere.botcommand.exception.BotCommandException;
import com.automationanywhere.commandsdk.i18n.Messages;
import com.automationanywhere.commandsdk.i18n.MessagesFactory;
import java.lang.ClassCastException;
import java.lang.Deprecated;
import java.lang.Object;
import java.lang.String;
import java.lang.Throwable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class GroupTypeDemoCommand implements BotCommand {
  private static final Logger logger = LogManager.getLogger(GroupTypeDemoCommand.class);

  private static final Messages MESSAGES_GENERIC = MessagesFactory.getMessages("com.automationanywhere.commandsdk.generic.messages");

  @Deprecated
  public Optional<Value> execute(Map<String, Value> parameters, Map<String, Object> sessionMap) {
    return execute(null, parameters, sessionMap);
  }

  public Optional<Value> execute(GlobalSessionContext globalSessionContext,
      Map<String, Value> parameters, Map<String, Object> sessionMap) {
    logger.traceEntry(() -> parameters != null ? parameters.entrySet().stream().filter(en -> !Arrays.asList( new String[] {}).contains(en.getKey()) && en.getValue() != null).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)).toString() : null, ()-> sessionMap != null ?sessionMap.toString() : null);
    GroupTypeDemo command = new GroupTypeDemo();
    HashMap<String, Object> convertedParameters = new HashMap<String, Object>();
    if(parameters.containsKey("nameGroup") && parameters.get("nameGroup") != null && parameters.get("nameGroup").get() != null) {
      convertedParameters.put("nameGroup", parameters.get("nameGroup").get());
      if(!(convertedParameters.get("nameGroup") instanceof String)) {
        throw new BotCommandException(MESSAGES_GENERIC.getString("generic.UnexpectedTypeReceived","nameGroup", "String", parameters.get("nameGroup").get().getClass().getSimpleName()));
      }
    }
    if(parameters.containsKey("firstName") && parameters.get("firstName") != null && parameters.get("firstName").get() != null) {
      convertedParameters.put("firstName", parameters.get("firstName").get());
      if(!(convertedParameters.get("firstName") instanceof String)) {
        throw new BotCommandException(MESSAGES_GENERIC.getString("generic.UnexpectedTypeReceived","firstName", "String", parameters.get("firstName").get().getClass().getSimpleName()));
      }
    }
    if(convertedParameters.get("firstName") == null) {
      throw new BotCommandException(MESSAGES_GENERIC.getString("generic.validation.notEmpty","firstName"));
    }

    if(parameters.containsKey("lastName") && parameters.get("lastName") != null && parameters.get("lastName").get() != null) {
      convertedParameters.put("lastName", parameters.get("lastName").get());
      if(!(convertedParameters.get("lastName") instanceof String)) {
        throw new BotCommandException(MESSAGES_GENERIC.getString("generic.UnexpectedTypeReceived","lastName", "String", parameters.get("lastName").get().getClass().getSimpleName()));
      }
    }
    if(convertedParameters.get("lastName") == null) {
      throw new BotCommandException(MESSAGES_GENERIC.getString("generic.validation.notEmpty","lastName"));
    }


    try {
      Optional<Value> result =  Optional.ofNullable(command.printName((String)convertedParameters.get("firstName"),(String)convertedParameters.get("lastName")));
      return logger.traceExit(result);
    }
    catch (ClassCastException e) {
      throw new BotCommandException(MESSAGES_GENERIC.getString("generic.IllegalParameters","printName"));
    }
    catch (BotCommandException e) {
      logger.fatal(e.getMessage(),e);
      throw e;
    }
    catch (Throwable e) {
      logger.fatal(e.getMessage(),e);
      throw new BotCommandException(MESSAGES_GENERIC.getString("generic.NotBotCommandException",e.getMessage()),e);
    }
  }
}
