package layouts.entrada;

import layouts.LayoutBase;
import layouts.Layouts;
import layouts.Telas;

import java.util.ArrayList;

public class Entrada extends LayoutBase {
    Layouts layouts;
    public void ConfiguraTela(int escolha){
        if (escolha == 0){
            layouts = Layouts.ENTRADA;
            super.setMenu_name(layouts.getMenu_name());
            super.setButton_value(layouts.getButton_value());
            super.setItem_1(layouts.getItem_1());
            super.setItem_2(layouts.getItem_2());
            super.setItem_3(layouts.getItem_3());
            super.setItem_4(layouts.getItem_4());
            super.setItem_5(layouts.getItem_5());
            super.setGetLastNullOptions(layouts.getLastNullOptions());
        }else if (escolha == 1){
            layouts = Layouts.ENTRADA_INCLUSAO;
            super.setMenu_name(layouts.getMenu_name());
            super.setButton_value(layouts.getButton_value());
            super.setItem_1(layouts.getItem_1());
            super.setItem_2(layouts.getItem_2());
            super.setItem_3(layouts.getItem_3());
            super.setItem_4(layouts.getItem_4());
            super.setItem_5(layouts.getItem_5());
            super.setGetLastNullOptions(layouts.getLastNullOptions());
        }
        else if (escolha == 2){
            layouts = Layouts.ENTRADA_ALTERACAO;
            super.setMenu_name(layouts.getMenu_name());
            super.setButton_value(layouts.getButton_value());
            super.setItem_1(layouts.getItem_1());
            super.setItem_2(layouts.getItem_2());
            super.setItem_3(layouts.getItem_3());
            super.setItem_4(layouts.getItem_4());
            super.setItem_5(layouts.getItem_5());
            super.setGetLastNullOptions(layouts.getLastNullOptions());
        }
        else if (escolha == 3){
            layouts = Layouts.ENTRADA_CONSULTA;
            super.setMenu_name(layouts.getMenu_name());
            super.setButton_value(layouts.getButton_value());
            super.setItem_1(layouts.getItem_1());
            super.setItem_2(layouts.getItem_2());
            super.setItem_3(layouts.getItem_3());
            super.setItem_4(layouts.getItem_4());
            super.setItem_5(layouts.getItem_5());
            super.setGetLastNullOptions(layouts.getLastNullOptions());

        }
        else if (escolha == 4){
            layouts = Layouts.ENTRADA_EXCLUSAO;
            super.setMenu_name(layouts.getMenu_name());
            super.setButton_value(layouts.getButton_value());
            super.setItem_1(layouts.getItem_1());
            super.setItem_2(layouts.getItem_2());
            super.setItem_3(layouts.getItem_3());
            super.setItem_4(layouts.getItem_4());
            super.setItem_5(layouts.getItem_5());
            super.setGetLastNullOptions(layouts.getLastNullOptions());
        }
    }
    public void Entrada(int escolha){
        if(escolha == 1){
            ConfiguraTela(1);
        }else if(escolha == 2){
            ConfiguraTela(2);
        }else if(escolha == 3){
            ConfiguraTela(3);
        }else if(escolha == 4){
            ConfiguraTela(4);
        }else if(escolha == 5){
            ConfiguraTela(5);
        }else{

        }
    }
}
