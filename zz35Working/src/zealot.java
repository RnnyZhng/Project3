import java.util.*;

public class zealot extends typeOfConstruction {
    HashMap<Integer, Boolean> gateMap = new HashMap<>();

    public zealot(HashMap<Integer, Integer> totalmap, int newId, int initialId, int constructTime,
                  int currTime,
                  int totalMinerals, int totalGas,
                  int spendingCost, int spendingGas,
                  HashMap<Integer, Boolean> gateWayMap) {
        super(totalmap, newId, initialId, constructTime, currTime, totalMinerals, totalGas);
        this.spendingCost = spendingCost;
        this.spendingGas = spendingGas;
        gateMap.putAll(gateWayMap);
    }

    /**
     * Judgement step: 1. dependent building exists 2. it is available 3. currency enough.
     * @param amount the number of units need to be added.
     */
    public void processActionInput(String amount) {
        numberOfAction = Integer.parseInt(amount);
        if (judgementDependentBuilding()) {             //dependent building exists
            if (checkFacilityAvailable(gateMap)) {      // if the gateWay is available.
                if (constructionCurrencyJudgement()) {  //if currency is enough.
                    deduceCurrency();
                    setComplexBuilding(gateMap);
                    System.out.println("Constructing the number of new unit(s) " + numberOfAction + "...");
                } else {
                    System.out.println("Invalid: The minerals or gas is not enough.");
                }
            } else {
                System.out.println("Invalid: The gate way has been used or not enough to build other unit.");
            }
        } else {
            System.out.println("Invalid: firstly construct the DEPENDENT building.");
        }
    }

    /**
     * test whether there exist gate Way.
     * @return true presents exist.
     */
    public boolean judgementDependentBuilding() {
        return (totalMap.containsKey(5001) && (currTime - totalMap.get(5001) >= 65));
    }

    //getter method.
    /**
     * This method is to get the hash map.
     * @return the renewed hash map.
     */
    public HashMap<Integer, Boolean> getGateMap() {
        return gateMap;
    }
}
