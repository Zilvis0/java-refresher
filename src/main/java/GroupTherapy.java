public class GroupTherapy implements Billable{
    private String groupName;
    private int numberOfParticipants;
    private double pricePerParticipant;

    public GroupTherapy (String groupName, int numberOfParticipants, double pricePerParticipant){
        this.groupName = groupName;
        this.numberOfParticipants = numberOfParticipants;
        this.pricePerParticipant = pricePerParticipant;
    }

    @Override
    public double calculateTotalTreatmentCost(){
        return numberOfParticipants * pricePerParticipant;
    }
}
