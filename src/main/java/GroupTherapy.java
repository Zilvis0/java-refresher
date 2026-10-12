public class GroupTherapy implements Billable{
    private String groupName;
    private int numberOfParticipants;
    private double pricePerParticipant;

    public GroupTherapy (String groupName, int numberOfParticipants, double pricePerParticipant){
        if(numberOfParticipants < 0 || pricePerParticipant < 0){
            throw new IllegalArgumentException("No negative values are allowed");
        }
        this.groupName = groupName;
        this.numberOfParticipants = numberOfParticipants;
        this.pricePerParticipant = pricePerParticipant;
    }

    @Override
    public double calculateTotalTreatmentCost(){
        return numberOfParticipants * pricePerParticipant;
    }
}
