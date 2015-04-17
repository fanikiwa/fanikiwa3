package com.sp.fanikiwa.entity;

import java.util.List;

public class BatchSimulateStatus {
	public BatchSimulateStatus(List<SimulatePostStatus> status) {
		SimulateStatus = status;
	}

	public boolean CanPost() {

		boolean canPost = true;
		for (SimulatePostStatus s : SimulateStatus)
			canPost = s.isCanPost();
		return canPost;
	}

	public List<SimulatePostStatus> SimulateStatus;
}
