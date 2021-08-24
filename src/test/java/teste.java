import com.automationanywhere.botcommand.data.Value;
import com.automationanywhere.botcommand.data.impl.StringValue;
import com.automationanywhere.botcommand.samples.commands.basic.Concatenate;
import com.automationanywhere.botcommand.samples.conditional.EmailValidate;
import org.testng.annotations.Test;

import javax.management.ValueExp;

public class teste {
//    @Test
//    public void StringConcatenate(){
//
//        Concatenate act = new Concatenate();
//        Value sv = act.action("BRASIL ACIMA DE TUDO", "DEUS ACIMA DE TODOS!!");
//        System.out.println(sv.get());
//
//    }

    @Test
    public void EmailTest(){
        EmailValidate val = new EmailValidate();

        String email = "asdasd@asdad.com";

        System.out.println("o email:" + email + " é " + val.validate(email));

    }

    //testar mais de uma action basta passar @Test
//    public void SegundaAction(){
//
//        Concatenate act = new Concatenate();
//        Value sv = act.action("BRASIL ACIMA DE TUDO", "DEUS ACIMA DE TODOS!!");
//        System.out.println(sv.get());
//
//    }

}


