package com.automationanywhere.botcommand.samples.commands.basic.desktopoperation;

import com.automationanywhere.botcommand.data.Value;
import com.automationanywhere.botcommand.data.model.SelectItem;
import com.automationanywhere.botcommand.exception.BotCommandException;
import com.automationanywhere.commandsdk.i18n.Messages;
import com.automationanywhere.commandsdk.i18n.MessagesFactory;
import com.automationanywhere.toolchain.runtime.DesktopOperationSelect;
import java.lang.ClassCastException;
import java.lang.Deprecated;
import java.lang.Object;
import java.lang.String;
import java.lang.Throwable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class DesktopOperationSelectSampleClassDesktopOperationSelect implements DesktopOperationSelect {
  private static final Logger logger = LogManager.getLogger(DesktopOperationSelectSampleClassDesktopOperationSelect.class);

  private static final Messages MESSAGES_GENERIC = MessagesFactory.getMessages("com.automationanywhere.commandsdk.generic.messages");

  @Deprecated
  public List<SelectItem> execute(Map<String, Value> input) {
    logger.traceEntry(() -> input != null ? input.entrySet().stream().filter(en -> !Arrays.asList( new String[] {}).contains(en.getKey()) && en.getValue() != null).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)).toString() : null);
    DesktopOperationSelectSampleClass command = new DesktopOperationSelectSampleClass();
    HashMap<String, Object> convertedParameters = new HashMap<String, Object>();
    logger.debug("Size of input:" + input.size());
    logger.debug("Content of input:" + input);
    convertedParameters.put("input", input);
    try {
      List<SelectItem> result = command.execute((Map<String, Value>)convertedParameters.get("input"));
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
