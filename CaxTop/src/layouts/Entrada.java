package layouts;

public class Entrada extends LayoutBase {
    Layouts layouts;
    public void ConfiguraTela(int escolha){
        if (escolha == 0){
            layouts = Layouts.ENTRADA;
        }else if (escolha == 1){
            layouts = Layouts.ENTRADA_INCLUSAO;
        }
        else if (escolha == 2){
            layouts = Layouts.ENTRADA_ALTERACAO;
        }
        else if (escolha == 3){
            layouts = Layouts.ENTRADA_CONSULTA;
        }
        else if (escolha == 4){
            layouts = Layouts.ENTRADA_EXCLUSAO;
        }
    }
    public void Entrada(int escolha){
        try {
            switch (escolha){
                case 0:
                    ConfiguraTela(0);
                    break;
                case 1:
                    ConfiguraTela(1);
                    break;
                case 2:
                    ConfiguraTela(2);
                    break;
                case 3:
                    ConfiguraTela(3);
                    break;
                case 4:
                    ConfiguraTela(4);
                    break;
            }

        }catch (Exception e){
            System.out.println(e);
        }finally {
            super.setOperation_id(layouts.getOperationId());
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
}
