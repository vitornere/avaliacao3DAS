package Cadastros;

public class DuracaoHoras {

    public static final int ZERO_HORAS = 0;
    public static final int UMA_HORAS = 1;
    public static final int DUAS_HORAS = 2;
    public static final int HORA_TERMINO_NAO_REGISTRADA = -1;

    private int horaTermino;
    private int horaInicio;
    private int minutosTermino;
    private int minutosInicio;

    public DuracaoHoras(int horaTermino, int horaInicio, int minutosTermino, int minutosInicio) {
        this.horaTermino = horaTermino;
        this.horaInicio = horaInicio;
        this.minutosTermino = minutosTermino;
        this.minutosInicio = minutosInicio;
    }

    public int computar() {
        if (isHoraIgual(horaTermino, horaInicio)) {
            return ZERO_HORAS;
        } else if (isHoraMaior(horaTermino, horaInicio)) { //varias possibilidades...
            return calculaHoraMaior();
        }

        return HORA_TERMINO_NAO_REGISTRADA; //para casos em que a hora de termino nao foi registrada
    }

    private int calculaHoraMaior() {
        if (isHoraIgual(horaTermino, horaInicio + UMA_HORAS)) {
            return calculaAteUmaHora();
        }

        //possivelmente ultrapassou duas horas
        return calculaMaiorDuasHoras();
    }

    private int calculaMaiorDuasHoras() {
        final int horaCalculada = calculaHora();

        if (isHoraMaior(horaCalculada, DUAS_HORAS)) {
            return horaCalculada;
        } else if (isHoraIgual(horaCalculada, DUAS_HORAS) && isHoraTerminoMenorInicio()) {
            //certamente menos de duas horas e mais de uma hora
            return UMA_HORAS;
        }

        return DUAS_HORAS;
    }

    private int calculaHora() {
        return horaTermino - horaInicio;
    }

    private int calculaAteUmaHora() {
        if (isHoraTerminoMenorInicio()) {  //nao chegou a uma hora
            return ZERO_HORAS;
        }

        //durou pelo menos uma hora
        return UMA_HORAS;
    }

    private boolean isHoraTerminoMenorInicio() {
        return minutosTermino < minutosInicio;
    }

    private boolean isHoraMaior(int horaTermino, int horaInicio) {
        return horaTermino > horaInicio;
    }

    private boolean isHoraIgual(int horaTermino, int horaInicio) {
        return horaTermino == horaInicio;
    }
}
