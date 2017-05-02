package api;

public class SumAPI {

	private final long id;
	private final String content;

	public SumAPI(long id, String content) {
		this.id = id;
		this.content = content;
	}

	public long getId() {
		return id;
	}

	public String getContent() {
		return content;
	}
}
