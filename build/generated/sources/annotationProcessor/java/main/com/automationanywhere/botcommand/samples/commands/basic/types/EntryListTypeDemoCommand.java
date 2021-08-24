package com.automationanywhere.botcommand.samples.commands.basic.types;

import com.automationanywhere.bot.service.GlobalSessionContext;
import com.automationanywhere.botcommand.BotCommand;
import com.automationanywhere.botcommand.data.Value;
import com.automationanywhere.botcommand.data.impl.DictionaryValue;
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
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class EntryListTypeDemoCommand implements BotCommand {
  private static final Logger logger = LogManager.getLogger(EntryListTypeDemoCommand.class);

  private static final Messages MESSAGES_GENERIC = MessagesFactory.getMessages("com.automationanywhere.commandsdk.generic.messages");

  @Deprecated
  public Optional<Value> execute(Map<String, Value> parameters, Map<String, Object> sessionMap) {
    return execute(null, parameters, sessionMap);
  }

  public Optional<Value> execute(GlobalSessionContext globalSessionContext,
      Map<String, Value> parameters, Map<String, Object> sessionMap) {
    logger.traceEntry(() -> parameters != null ? parameters.entrySet().stream().filter(en -> !Arrays.asList( new String[] {}).contains(en.getKey()) && en.getValue() != null).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)).toString() : null, ()-> sessionMap != null ?sessionMap.toString() : null);
    EntryListTypeDemo command = new EntryListTypeDemo();
    HashMap<String, Object> convertedParameters = new HashMap<String, Object>();
    if(parameters.containsKey("entryList") && parameters.get("entryList") != null && parameters.get("entryList").get() != null) {
      convertedParameters.put("entryList", parameters.get("entryList").get());
      if(!(convertedParameters.get("entryList") instanceof List)) {
        throw new BotCommandException(MESSAGES_GENERIC.getString("generic.UnexpectedTypeReceived","entryList", "List", parameters.get("entryList").get().getClass().getSimpleName()));
      }
    }
    if(convertedParameters.containsKey("entryList")) {
      try {
        List<Value> entryList = (List<Value>)convertedParameters.get("entryList");
        for(Value element:entryList)  {
          DictionaryValue dictionaryValue=(DictionaryValue)element;
          Map<String,Value> valueMap=dictionaryValue.get();
          HashSet<Value> uniqueValueSet=new HashSet() ;
          for (Map.Entry<String,Value> entry: valueMap.entrySet()) {
            if(entry.getKey().equals("NAME")  && uniqueValueSet.contains(entry.getValue()))  {
              throw new BotCommandException(MESSAGES_GENERIC.getString("entrylist.duplicate.rows.added","NAME"));
            }
            else if (entry.getKey().equals("NAME"))  {
              uniqueValueSet.add(entry.getValue());
            }
          }
        }
      }
      catch(ClassCastException e) {
        throw new BotCommandException(MESSAGES_GENERIC.getString("generic.UnexpectedTypeReceived","entryList", "List<Value>",convertedParameters.get("entryList").getClass().getSimpleName()));
      }


      if(parameters.containsKey("name") && parameters.get("name") != null && parameters.get("name").get() != null) {
        convertedParameters.put("name", parameters.get("name").get());
        if(!(convertedParameters.get("name") instanceof String)) {
          throw new BotCommandException(MESSAGES_GENERIC.getString("generic.UnexpectedTypeReceived","name", "String", parameters.get("name").get().getClass().getSimpleName()));
        }
      }

      if(parameters.containsKey("city") && parameters.get("city") != null && parameters.get("city").get() != null) {
        convertedParameters.put("city", parameters.get("city").get());
        if(!(convertedParameters.get("city") instanceof String)) {
          throw new BotCommandException(MESSAGES_GENERIC.getString("generic.UnexpectedTypeReceived","city", "String", parameters.get("city").get().getClass().getSimpleName()));
        }
      }


    }
    try {
      command.setParameter((List<Value>)convertedParameters.get("entryList"));Optional<Value> result = Optional.empty();
      return logger.traceExit(result);
    }
    catch (ClassCastException e) {
      throw new BotCommandException(MESSAGES_GENERIC.getString("generic.IllegalParameters","setParameter"));
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
