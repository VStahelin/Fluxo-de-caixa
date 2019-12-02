package layouts.relatorios;

import layouts.LayoutBase;
import layouts.Layouts;

public class Relatorio extends LayoutBase {

    public void ConfiguraTela(){
        Layouts layouts = Layouts.RELATORIO;
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
