package myspring.aop.xml;

import org.aspectj.lang.ProceedingJoinPoint;

public class PerformanceTraceAdvice {
	public Object trace(ProceedingJoinPoint joinPoint)throws Throwable{
		//타겟 메서드의 signture  정보
		String signatureString = joinPoint.getSignature().toString();
		System.out.println(signatureString + " 시작");
		
		//타겟의 메서드가 호출되기 전의 시간
		long start = System.currentTimeMillis();
		try {
			//타겟의 메서드 호출
			Object result = joinPoint.proceed();
			return result;
		} finally {
			//타겟의 메서드가 호출된 후의 시간
			long finish = System.currentTimeMillis();
			System.out.println(signatureString + " 종료");
			System.out.println(signatureString + " 실행시간 : " + (finish  - start) + " ms");
		}
	}
	
}
