package Cadastros;

public class DuracaoMinutos {

    private int minutosTermino;
    private int minutosInicio;

    public DuracaoMinutos(int minutosTermino, int minutosInicio) {
        this.minutosTermino = minutosTermino;
        this.minutosInicio = minutosInicio;
    }

    public int computar() {
        int duracaoMinutos;

        if (minutosTermino > minutosInicio)
            duracaoMinutos = minutosTermino - minutosInicio;
        else {
            duracaoMinutos = 60 - minutosInicio + minutosTermino;
            if (duracaoMinutos == 60) //caso especial
                duracaoMinutos = 0;
        }
        return duracaoMinutos;
    }
}
