package health;

import com.codahale.metrics.health.HealthCheck;

public class DemoHealthCheck extends HealthCheck {

	public DemoHealthCheck() {
		super();
	}

	@Override
	protected Result check() throws Exception {
		return Result.healthy();
	}
}
