package layouts;

public class Entrada extends LayoutBase{
    Layouts layouts = Layouts.ENTRADA_INCLUSAO;
    public void ConfiguraTela(){
        super.setMenu_name(layouts.getMenu_name());
        super.setItem_1(layouts.getItem_1());
        super.setItem_2(layouts.getItem_2());
        super.setItem_3(layouts.getItem_3());
        super.setItem_4(layouts.getItem_4());
        super.setItem_5(layouts.getItem_5());
    }
}