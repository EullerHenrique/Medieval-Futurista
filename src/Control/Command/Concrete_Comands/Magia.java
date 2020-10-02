package Control.Command.Concrete_Comands;

import Control.Command.Command.Comando;
import Model.Decorator.ConcreteDecorators.Gancho;
import Model.Decorator.ConcreteDecorators.Joelhada;
import Model.Decorator.ConcreteDecorators.Nocaute;
import Model.Strategy.Context__Personagem.Personagem;
import Model.Strategy.Strategy_3_Ataque.Ataque;

public class Magia extends Comando {
    Personagem atacado;

    public Magia(Personagem atacante, Personagem atacado) {
        super(atacante);
        this.atacado = atacado;
    }

    public void execute() {
        Ataque ataque = getPersonagem().getAtaque();

        Ataque golpe = ataque;
        golpe =  new Joelhada(golpe);
        golpe = new Gancho(golpe);
        golpe = new Nocaute(golpe);

        getPersonagem().setAtaque(golpe);

        getPersonagem().atacar(atacado);

        getPersonagem().setAtaque(ataque);

    }
}
