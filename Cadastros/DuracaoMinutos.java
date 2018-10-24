package Cadastros;

public class DuracaoMinutos {

    public static final int SESSENTA_MINUTOS = 60;
    public static final int ZERO_MINUTOS = 0;
    private int minutosTermino;
    private int minutosInicio;

    public DuracaoMinutos(int minutosTermino, int minutosInicio) {
        this.minutosTermino = minutosTermino;
        this.minutosInicio = minutosInicio;
    }

    public int computar() {
        if (isMinTerminoMaiorMinInicio())
            return calculaMinTerminoMaiorMinInicio();
        else {
            return calculaMinTerminoMenorMinInicio();
        }
    }

    private boolean isMinTerminoMaiorMinInicio() {
        return minutosTermino > minutosInicio;
    }

    private int calculaMinTerminoMenorMinInicio() {
        final int duracaoMinutos = calculaDuracaoMinutosSemCasoEspecial();

        if (duracaoMinutos == SESSENTA_MINUTOS) //caso especial
            return ZERO_MINUTOS;

        return duracaoMinutos;
    }
    private int calculaMinTerminoMaiorMinInicio() {
        return minutosTermino - minutosInicio;
    }

    private int calculaDuracaoMinutosSemCasoEspecial() {
        return (SESSENTA_MINUTOS - minutosInicio) + minutosTermino;
    }
}
