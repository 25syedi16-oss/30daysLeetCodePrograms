class ParkingSystem {
    private int[] spaces;

    public ParkingSystem(int big, int medium, int small) {
        // Map spaces directly into a internal array
        this.spaces = new int[]{big, medium, small};
    }
    
    public boolean addCar(int carType) {
        // carType 1 maps to index 0, 2 maps to index 1, etc.
        if (spaces[carType - 1] > 0) {
            spaces[carType - 1]--;
            return true;
        }
        return false;
    }
}