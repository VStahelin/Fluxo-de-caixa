package layouts;

public enum Layouts {

    ENTRADA_INCLUSAO("Cadastro de entrada\n", "Documento: ","Descricao: ",
            "Data de operacao","Valor",""),
    ENTRADA_ALTERACAO("Inclusao de entrada\n", "Documento: ","Descricao: ",
            "Data de operacao: ","Valor: ",""),
    ENTRADA_CONSULTA("Consulta de entrada\n", "Documento: ","Descricao: ",
            "Valor: ","",""),
    ENTRADA_EXCLUSAO("Exclusao de entrada\n", "Documento: ","Descricao: ",
            "Valor: ","",""),
    ;

    private String menu_name;
    private String item_1;
    private String item_2;
    private String item_3;
    private String item_4;
    private String item_5;

    Layouts(String menu_name, String item_1, String item_2,
            String item_3, String item_4, String item_5) {
        this.menu_name = menu_name;
        this.item_1 = item_1;
        this.item_2 = item_2;
        this.item_3 = item_3;
        this.item_4 = item_4;
        this.item_5 = item_5;
    }

    public String getMenu_name() {
        return menu_name;
    }

    public void setMenu_name(String menu_name) {
        this.menu_name = menu_name;
    }

    public String getItem_1() {
        return item_1;
    }

    public void setItem_1(String item_1) {
        this.item_1 = item_1;
    }

    public String getItem_2() {
        return item_2;
    }

    public void setItem_2(String item_2) {
        this.item_2 = item_2;
    }

    public String getItem_3() {
        return item_3;
    }

    public void setItem_3(String item_3) {
        this.item_3 = item_3;
    }

    public String getItem_4() {
        return item_4;
    }

    public void setItem_4(String item_4) {
        this.item_4 = item_4;
    }

    public String getItem_5() {
        return item_5;
    }

    public void setItem_5(String item_5) {
        this.item_5 = item_5;
    }
}
