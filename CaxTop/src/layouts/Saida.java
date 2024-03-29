package layouts;

public class Saida extends LayoutBase {
    Layouts layouts;
    public void configuraTela(int escolha) {
        switch (escolha) {
            case 0:
                layouts = Layouts.SAIDA;
                break;
            case 1:
                layouts = Layouts.SAIDA_INCLUSAO;
                break;
            case 2:
                layouts = Layouts.SAIDA_ALTERACAO;
                break;
            case 3:
                layouts = Layouts.SAIDA_CONSULTA;
                break;
            case 4:
                layouts = Layouts.SAIDA_EXCLUSAO;
                break;
        }
    }
    public void saida(int escolha){
        try {
            switch (escolha){
                case 0:
                    configuraTela(0);
                    break;
                case 1:
                    configuraTela(1);
                    break;
                case 2:
                    configuraTela(2);
                    break;
                case 3:
                    configuraTela(3);
                    break;
                case 4:
                    configuraTela(4);
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
