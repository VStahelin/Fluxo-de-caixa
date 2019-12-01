package layouts;

import java.util.List;

public interface Acao {
    List Entrada (String acao);
    List Saida (String acao);
    List Alteracao (String acao);
    List Exclusao (String acao);
}
