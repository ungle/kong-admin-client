package io.github.ungle.kong.client.model.plugins.traffic;

import java.util.Objects;
import java.util.stream.Stream;

/**
 * inner class for ResponseRateLimiting
 * @author ungle
 *
 */
public class RateLimitData {
	private Long second;
	private Long minute;
	private Long hour;
	private Long day;
	private Long month;
	private Long year;
	private RateLimitData(Builder builder) {
		this.second = builder.second;
		this.minute = builder.minute;
		this.hour = builder.hour;
		this.day = builder.day;
		this.month = builder.month;
		this.year = builder.year;
	}
	public Long getSecond() {
		return second;
	}
	public Long getMinute() {
		return minute;
	}
	public Long getHour() {
		return hour;
	}
	public Long getDay() {
		return day;
	}
	public Long getMonth() {
		return month;
	}
	public Long getYear() {
		return year;
	}
	public static Builder builder() {
		return new Builder();
	}
	public static final class Builder {
		private Long second;
		private Long minute;
		private Long hour;
		private Long day;
		private Long month;
		private Long year;

		private Builder() {
		}

		public Builder withSecond(Long second) {
			this.second = second;
			return this;
		}

		public Builder withMinute(Long minute) {
			this.minute = minute;
			return this;
		}

		public Builder withHour(Long hour) {
			this.hour = hour;
			return this;
		}

		public Builder withDay(Long day) {
			this.day = day;
			return this;
		}

		public Builder withMonth(Long month) {
			this.month = month;
			return this;
		}

		public Builder withYear(Long year) {
			this.year = year;
			return this;
		}
		
		private void verifyRate() {
			Long [] rates = {second, minute, hour, day, month, year};
			String[] periods = {"second", "minute", "hour", "day", "month", "year"};
			Stream<Long> stream = Stream.of(rates);
			if (stream.allMatch(Objects::isNull)) {
				throw new IllegalArgumentException(
						"the rate limit params second,minute,hour,day,month,year must have at least one non-null");
			}
			stream = Stream.of(rates);
			if (stream.filter(Objects::nonNull).anyMatch(t -> t <= 0)) {
				throw new IllegalArgumentException("the rate limit must greater than 0");
			}
			
			for(int i=0; i < rates.length-1;i++) {
				if(rates[i] == null) {
					continue;
				}
				for(int j =1; j < rates.length;j++) {
					if(rates[j] !=null && rates[j] < rates[i]) {
						throw new IllegalArgumentException(String.format("the limit for %s(%d) cannot be lower than the limit for %s(%d)", 
								periods[j],rates[j],periods[i],rates[i]));
					}
				}
			}
		}

		public RateLimitData build() {
			verifyRate();
			return new RateLimitData(this);
		}
	}

	

	
}