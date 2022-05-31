package com.datastructures.may;

import java.util.Arrays;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 31/05/22
 */
public class TransformString {
	public static int transform(String A, String B){
		char[] a = A.toCharArray();
		char[] b = B.toCharArray();

		if(A.length() != B.length()){
			return -1;
		}

		Arrays.sort(a);
		Arrays.sort(b);

		if(!Arrays.equals(a, b)){
			return -1;
		}

		int ans = 0;
		int i = A.length() -1;
		int j = B.length() - 1;

		while (i>=0){
			if(A.charAt(i) == B.charAt(j)){
				i--;
				j--;
			}else{
				ans++;
				i--;
			}

		}

		return ans;
	}

	public static void main(String[] args) {
		System.out.println(transform("wWkIfZirBvirHPunlMBRmtKUScoesPsBAGAYungWgrbhzBtyRQANHMKowHaoZuCyLiXjakLLzHqrKLbRHaYZcAbafzUaBZSyCYVmWppWJspfSRUitYnKGySDGrBJBCYELZkuIyujtNtHlBlaFCIKBiXnVpOUTKZOhwvOFxKfdvWfIHXEuQcQujhmlrefumHCQlbJiQMSoznsCarHiKNCDBFDdROdbhdQQfJRstdmlkIPRsrTNkNUThjFKvtsJOeZHIlktuZVKNkmooruEAZLVEMGlfKeabrWMmkcIJmdhhrifFPLQmugNYtMqDGpbzodXuXnTRFguBEZZhnulHGFvpPwVXLYofeFDRUXeyNCbuZFqjCQdSAZheHXTMZhPcDNTWiQBKdakUQcOKDjaFqpSelJYrLxayNdmovXtnrPQodHEdMDmqszStzsizksSEZJtvmWjWAoKemgiruZlYWEUUBLKIlspEbIpwjRbPZzAmqCNbsUsicAuvMIjgDzEjvCnVhsknaMWbpzSEQvNYPbVzfupZKwdjftgtzoDieJGHSXTQHwPpxWvofuqvDsrwHpTIbHAwcxJuHGzkRZtJeqstAIdvOYFSmYaiEqqWcvxsEdnevLiiZPfSyASdOIeQDMBGFCfjUCmyavFWLgTWIzPAizASHoqktYbDelxQtSKHvusnMAlQqTBxtGhcpLSvUhKbbJoWyljZOgwEBWQHjOUNwJPEqSeNNIGeNwNcPCDmzGzTQnaabmiPEJZBhpNhWWddXvZnsuLZPNdjpnMMTDFXnYMlmqRbxfWILmfdAbUdoTlETADabIaNCZwHLMjkiARFOXqMxmSeuXdWIQrfxBPhNVzRmVjVXOyoSkgGsssWDaB",
				"hZQQVXCVUtvzMNCfApArBJTGwxGVKNQzmttmjgcGbxveszTCEJRZFeoJPLctNKfnITVckSvkdQeVuPaPNHqBDCMcrSjmrKnlhgucDjbhKBJmLyjmrZgPDdwxInCBpEFlfWksOBtQGRQhtnHOQCDdbNVBjzDivnEEkJBROsGQnBAWoIfTqdmEAZyWESjsLUpRMjcBHHFcBUALXxYRVBEnwPotMOLBpJnHgbXHQVvqMCYHqldzXrXVkEiZUuaQqAKcfaJuDjAlCIMllIloPqoSDbjVmtBZudpbWfegHiHZcLKFNnrIwpvjgPxISlUTDiTXRyauyklyCINESPYZvOUuFbYHEZkUhbUArWaxVVqDfITEpZJylYvvHRltAwOxsFdKmojVrCfJqbYkxIltNahwwLnlUlgXTZAKSJXIwIxfgtFeovrBDBWYIuxHTPTxFWPJPXXxOYjUBbXTuEGJupviMkJvGfMqlSEogzDunKEKNMvmZxOLewJiFVyehafCCXCytTHIRtJcLurzpFGCFpsuFXLhjsJDKnGPzjXtRtXYjVSiMGvTSFRMdWbiKpLxCbPzdjPAbUJESeHJWlvdpGITPazfVQuCYVnAaiBOtsdAAqaSFRhAVTBLkfOJMJVpLrBwnEBTLZhpMtxtwyFCvozdgNgjISsAOregSdkJiCpicQYLNCkOfLmWmJvrHWngoyZQhzWAgZuNhwXfdbCniKHaogpHrUkJwhkSwphFoKEyHlvuQApyqltoaxvzmBCsKYsMHknunmYfYrKjYIjbtwvfdTsERKcnHuHDkMfZHitLCHwIzDjFkpXmmCpIWjHTrKHdrQQsspqHMOKJZZskUsBYmFyBLUDjGEovwzWETUfOyEtLo"));

		System.out.println(transform("abd", "bad"));
	}
}
