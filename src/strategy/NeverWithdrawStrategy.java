package strategy;

import java.util.ArrayList;
import java.util.List;

import coinpurse.Valuable;

public class NeverWithdrawStrategy implements WithdrawStrategy{

	@Override
	public List<Valuable> withdraw(Valuable amount, List<Valuable> valuable) {
		List<Valuable> nullValue = new ArrayList<>();
		return nullValue;
	}
}
