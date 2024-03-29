package com.automationanywhere.botcommand.samples.conditional;

import com.automationanywhere.bot.service.GlobalSessionContext;
import com.automationanywhere.botcommand.Condition;
import com.automationanywhere.botcommand.data.Value;
import com.automationanywhere.botcommand.exception.BotCommandException;
import com.automationanywhere.commandsdk.i18n.Messages;
import com.automationanywhere.commandsdk.i18n.MessagesFactory;
import java.lang.ClassCastException;
import java.lang.Object;
import java.lang.String;
import java.lang.Throwable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class EmailValidateCondition implements Condition {
  private static final Logger logger = LogManager.getLogger(EmailValidateCondition.class);

  private static final Messages MESSAGES_GENERIC = MessagesFactory.getMessages("com.automationanywhere.commandsdk.generic.messages");

  public boolean test(Map<String, Value> parameters) {
    return test(null, parameters, null);
  }

  public boolean test(GlobalSessionContext globalSessionContext, Map<String, Value> parameters,
      Map<String, Object> sessionMap) {
    logger.traceEntry(() -> parameters != null ? parameters.entrySet().stream().filter(en -> !Arrays.asList( new String[] {}).contains(en.getKey()) && en.getValue() != null).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)).toString() : null, ()-> sessionMap != null ?sessionMap.toString() : null);
    EmailValidate command = new EmailValidate();
    HashMap<String, Object> convertedParameters = new HashMap<String, Object>();
    if(parameters.containsKey("email") && parameters.get("email") != null && parameters.get("email").get() != null) {
      convertedParameters.put("email", parameters.get("email").get());
      if(!(convertedParameters.get("email") instanceof String)) {
        throw new BotCommandException(MESSAGES_GENERIC.getString("generic.UnexpectedTypeReceived","email", "String", parameters.get("email").get().getClass().getSimpleName()));
      }
    }
    if(convertedParameters.get("email") == null) {
      throw new BotCommandException(MESSAGES_GENERIC.getString("generic.validation.notEmpty","email"));
    }

    try {
      boolean result = command.validate((String)convertedParameters.get("email"));
      return logger.traceExit(result);
    }
    catch (ClassCastException e) {
      throw new BotCommandException(MESSAGES_GENERIC.getString("generic.IllegalParameters","validate"));
    }
    catch (BotCommandException e) {
      logger.fatal(e.getMessage(), e);
      throw e;
    }
    catch (Throwable e) {
      logger.fatal(e.getMessage(),e);
      throw new BotCommandException(MESSAGES_GENERIC.getString("generic.NotBotCommandException",e.getMessage()),e);
    }
  }
}
