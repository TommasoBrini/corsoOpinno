public class DittaRipazioni {
    private TecniciList tecnici;

    private RiparazioniList riparazioniInAttesa = new RiparazioniList();

    public DittaRipazioni(TecniciList tecnici) {
        this.tecnici = tecnici;
    }

    public void addRiparazione(Riparazione riparazione){
        riparazioniInAttesa.add(riparazione);
    }

    public Riparazione[] getRiparazioniInAttesa() {
        return riparazioniInAttesa.getMyList();
    }

    public Riparazione getMaxPriority(){
        int i = 0;
        Riparazione rip = null;
        for (Riparazione riparazione : riparazioniInAttesa.getMyList()) {
            if(i < riparazione.getPriorità()){
                if(riparazione.getConclusa().equals("")){
                    i = riparazione.getPriorità();
                    rip = riparazione;
                }
            }
        }
        return rip;
    }

    public boolean assegnaRiparazione(String nomeTecnico){
        Riparazione rip = getMaxPriority();
        if(rip.getConclusa().equals("")){
            for (Tecnico tecnico : tecnici.getMyList()) {
                if(tecnico.getNome().equals(nomeTecnico)){
                    if(!tecnico.isFerie()){
                        System.out.println("Riparazione in via " + rip.getIndirizzo() + " assegnata");
                        rip.setConclusa(nomeTecnico);
                        return true;
                    } else {
                        System.out.println("Il tecnico " + nomeTecnico + " è al mare");
                        return false;
                    }

                }
            }
            System.out.println("Tecnico non trovato");
        } else {
            System.out.println("Riparazione già assegnata");
            return true;
        }
        return false;
    }

    public void addTec(Tecnico tecnico){
        tecnici.add(tecnico);
    }

    public void mandaFerie(String tecNome){
        for (Tecnico tecnico : tecnici.getMyList()) {
            if(tecnico.getNome().equals(tecNome)){
                tecnico.setFerie(true);
            }
        }
    }
}
