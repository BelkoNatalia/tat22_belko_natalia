package classesTask.optionalTasks.house.entity;

public class Flat {
	
	private int idOfFlat;
	private int numberOfFlat;
	private double areaOfFlat;
	private int floorOfFlat;
	private int quantityOfRooms;

	public Flat() {
	}

	public Flat(int idOfFlat, int numberOfFlat, double areaOfFlat, int floorOfFlat, int quantityOfRooms) {
		this();
		this.idOfFlat = idOfFlat;
		this.numberOfFlat = numberOfFlat;
		this.areaOfFlat = areaOfFlat;
		this.floorOfFlat = floorOfFlat;
		this.quantityOfRooms = quantityOfRooms;
	}

	public int getIdOfFlat() {
		return idOfFlat;
	}

	public void setIdOfFlat(int idOfFlat) {
		this.idOfFlat = idOfFlat;
	}

	public int getNumberOfFlat() {
		return numberOfFlat;
	}

	public void setNumberOfFlat(int numberOfFlat) {
		this.numberOfFlat = numberOfFlat;
	}

	public double getAreaOfFlat() {
		return areaOfFlat;
	}

	public void setAreaOfFlat(double areaOfFlat) {
		this.areaOfFlat = areaOfFlat;
	}

	public int getFloorOfFlat() {
		return floorOfFlat;
	}

	public void setFloorOfFlat(int floorOfFlat) {
		this.floorOfFlat = floorOfFlat;
	}

	public int getQuantityOfRooms() {
		return quantityOfRooms;
	}

	public void setQuantityOfRooms(int quantityOfRooms) {
		this.quantityOfRooms = quantityOfRooms;
	}

	@Override
	public String toString() {
		return "Flat №" + numberOfFlat + " [idOfFlat=" + idOfFlat + ", numberOfFlat=" + numberOfFlat + ", areaOfFlat=" + areaOfFlat + ", floorOfFlat=" + floorOfFlat
				+ ", quantityOfRooms=" + quantityOfRooms;
	}
}