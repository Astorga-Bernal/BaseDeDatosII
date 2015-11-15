package src.mysql;

public class Restiction {

	private ActionEvent event;
	private Action action;

	public Restiction() {
		super();
	}

	public Restiction(ActionEvent event, Action action) {
		super();
		this.event = event;
		this.action = action;
	}

	public ActionEvent getEvent() {
		return event;
	}

	public void setEvent(ActionEvent event) {
		this.event = event;
	}

	public Action getAction() {
		return action;
	}

	public void setAction(Action action) {
		this.action = action;
	}

	public boolean equals(Restiction restiction){
		boolean eq = true;
		eq &= event.equals(restiction.getEvent());
		eq &= action.equals(restiction.getAction());
		return eq;
	}
}
