package src.mysql;

public class Trigger {

	private String name;
	private Timing timing;
	private Event event;
	private String code;

	public Trigger() {
		super();

	}

	public Trigger(String name, Timing timing, Event event, String code) {
		super();
		this.name = name;
		this.timing = timing;
		this.event = event;
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timing getTiming() {
		return timing;
	}

	public void setTiming(Timing timing) {
		this.timing = timing;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
