package pluralsight.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import brave.sampler.Sampler;

@Configuration
public class CustomSampler {

	@Bean
	public Sampler smartSampler() {
		return new Sampler() {
			
			@Override
			public boolean isSampled(long traceId) {
				System.out.println("Custom sampler used!");
				return true;
			}
		};
	}
}
