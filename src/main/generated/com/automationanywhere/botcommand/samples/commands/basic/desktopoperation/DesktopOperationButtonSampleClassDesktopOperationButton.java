package com.automationanywhere.botcommand.samples.commands.basic.desktopoperation;

import com.automationanywhere.botcommand.data.Value;
import com.automationanywhere.botcommand.exception.BotCommandException;
import com.automationanywhere.commandsdk.i18n.Messages;
import com.automationanywhere.commandsdk.i18n.MessagesFactory;
import com.automationanywhere.toolchain.runtime.DesktopOperationButton;
import java.lang.ClassCastException;
import java.lang.Deprecated;
import java.lang.Object;
import java.lang.String;
import java.lang.Throwable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class DesktopOperationButtonSampleClassDesktopOperationButton implements DesktopOperationButton {
  private static final Logger logger = LogManager.getLogger(DesktopOperationButtonSampleClassDesktopOperationButton.class);

  private static final Messages MESSAGES_GENERIC = MessagesFactory.getMessages("com.automationanywhere.commandsdk.generic.messages");

  @Deprecated
  public Map<String, Value> execute(Map<String, Value> input) {
    logger.traceEntry(() -> input != null ? input.entrySet().stream().filter(en -> !Arrays.asList( new String[] {}).contains(en.getKey()) && en.getValue() != null).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)).toString() : null);
    DesktopOperationButtonSampleClass command = new DesktopOperationButtonSampleClass();
    HashMap<String, Object> convertedParameters = new HashMap<String, Object>();
    convertedParameters.put("input", input);
    try {
      Map<String, Value> result = command.execute((Map<String, Value>)convertedParameters.get("input"));
      return logger.traceExit(result);
    }
    catch (ClassCastException e) {
      throw new BotCommandException(MESSAGES_GENERIC.getString("generic.IllegalParameters","execute"));
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
