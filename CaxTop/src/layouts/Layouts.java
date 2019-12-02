package layouts;

public enum Layouts {

    ENTRADA("Cadastro de entrada",
            "Cadastrar",
            "Inclusao: ",
            "Alteracao: ",
            "colsulta: ",
            "Exclusao: ",
            null,
            1),
    ENTRADA_INCLUSAO("Inclusao de entrada",
            "Cadastrar",
            "Documento: ",
            "Descricao: ",
            "Data de operacao: ",
            "Valor: ",
            null,
            1),
    ENTRADA_ALTERACAO("Alteracao de entrada",
            "Alterar: ",
            "Documento: ",
            "Descricao: ",
            "Data de operacao: ",
            "Valor: ",
            null,
            1),
    ENTRADA_CONSULTA("Consulta de entrada\n",
            "Nova Consulta? ",
            "Documento: ",
            "Descricao: ",
            "Valor: ",
            null,
            null,
            2),
    ENTRADA_EXCLUSAO("Exclusao de entrada",
            "Nova Exclusao? ",
            "Documento: ",
            "Descricao: ",
            "Valor: ",
            null,
            null,
            2),

    SAIDA("Cadastro de Saida",
            "Cadastrar",
            "Inclusao: ",
            "Alteracao: ",
            "colsulta: ",
            "Exclusao: ",
            null,
            1),
    SAIDA_INCLUSAO("Inclusao de saida",
            "Cadastrar",
            "Documento: ",
            "Descricao: ",
            "Data de operacao: ",
            "Valor: ",
            null,
            1),
    SAIDA_ALTERACAO("Alteracao de entrada",
            "Alterar: ",
            "Documento: ",
            "Descricao: ",
            "Data de operacao: ",
            "Valor: ",
            null,
            1),
    SAIDA_CONSULTA("Consulta de saida\n",
            "Nova Consulta? ",
            "Documento: ",
            "Descricao: ",
            "Valor: ",
            null,
            null,
            2),
    SAIDA_EXCLUSAO("Exclusao de saida",
            "Nova Exclusao? ",
            "Documento: ",
            "Descricao: ",
            "Valor: ",
            null,
            null,
            2),
    RELATORIO("Relatorio",
            "button_value",
            "item_1",
            "item_2",
            "item_3",
            "item_4",
            "item_5",
            0),
    ;

    private String menu_name;
    private String item_1;
    private String item_2;
    private String item_3;
    private String item_4;
    private String item_5;
    private String button_value;
    private int lastNullOptions;


    Layouts(String menu_name,
            String button_value,
            String item_1,
            String item_2,
            String item_3,
            String item_4,
            String item_5,
            int lastNullOptions) {

        this.menu_name = menu_name;
        this.item_1 = item_1;
        this.item_2 = item_2;
        this.item_3 = item_3;
        this.item_4 = item_4;
        this.item_5 = item_5;
        this.button_value = button_value;
        this.lastNullOptions = lastNullOptions;
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

    public String getButton_value() {
        return button_value;
    }

    public void setButton_value(String button_value) {
        this.button_value = button_value;
    }

    public int getLastNullOptions() {
        return lastNullOptions;
    }

    public void setLastNullOptions(int lastNullOptions) {
        this.lastNullOptions = lastNullOptions;
    }
}
