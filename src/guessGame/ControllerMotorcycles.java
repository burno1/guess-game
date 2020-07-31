package guessGame;

/**
 *
 * @author Bruno Fernandes
 */
public class ControllerMotorcycles {

    private NiceBike begin;
    private final int YES = 0;
    private final int NO = 1;

    public ControllerMotorcycles() {
        begin = sampleObject();
    }

    public NiceBike sampleObject() {

        NiceBike ninja = new NiceBike();
        ninja.setDescription("Ninja zx25r");
        ninja.setYes(null);
        ninja.setNo(null);

        NiceBike yamaha = new NiceBike();
        yamaha.setDescription("r25");
        yamaha.setYes(null);
        yamaha.setNo(null);

        NiceBike massa = new NiceBike();
        massa.setDescription("Fast AF boiii");
        massa.setYes(ninja);
        massa.setNo(yamaha);

        return massa;
    }

    public void initSearch() {
        next(begin);
    }

    public NiceBike next(NiceBike current) {
        int escolha = ViewBike.showMotorcycleQuestion(current.getDescription());
        NiceBike newNode;
        switch (escolha) {
            case YES:
                if (current.getYes() == null) {
                    ViewBike.showGuessed();
                    newNode = null;
                } else {
                    newNode = next(current.getYes());
                    if (newNode != null) {
                        current.setYes(newNode);
                        newNode = null;
                    }
                }
                break;
            case NO:
                if (current.getNo() == null) {
                    newNode = createNewNode(current);
                } else {
                    newNode = next(current.getNo());
                    if (newNode != null) {
                        current.setNo(newNode);
                        newNode = null;
                    }
                }
                break;
            default:
                newNode = null;
                break;
        }
        return newNode;
    }

    public NiceBike createNewNode(NiceBike current) {
        String newObjDescription = ViewBike.showNewBikeQuestion();
        
        if (newObjDescription != null) {
            newObjDescription = newObjDescription.trim();
            if (!newObjDescription.equals("")) {
                
                NiceBike novo = new NiceBike();
                novo.setDescription(newObjDescription);
                novo.setYes(null);
                novo.setNo(null);

                String diffCurrentOldDescription = ViewBike.showDifferenceQuestion(newObjDescription, current.getDescription());
                

                NiceBike differenceOldNew = new NiceBike();
                differenceOldNew.setDescription(diffCurrentOldDescription);
                differenceOldNew.setYes(novo);
                differenceOldNew.setNo(current);

                return differenceOldNew;
            }
        }
        return null;

    }
}
