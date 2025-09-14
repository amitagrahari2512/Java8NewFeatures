package com.example.demo.thencompose;

import java.util.concurrent.CompletableFuture;

// Get userId By UserName
// Get UserDeatils by UserId
// Get UserAddress by UserDetails
public class ThenComposeScenario {

		public CompletableFuture<String> getUserIdByUserName(String userName) {
			return CompletableFuture.supplyAsync(() -> userName + "_id");
		}
		
		public CompletableFuture<String> getUserDetailsByUserId(String userId) {
			return CompletableFuture.supplyAsync(() -> "Profile Of " + userId);
		}
		
		public CompletableFuture<String> getUserAddressByUserDetails(String userDeatils) {
			return CompletableFuture.supplyAsync(() -> "Address for " + userDeatils);
		}
		
		public void getAllDetailsOfUser(String userName) {
			CompletableFuture<String> profileFuture = getUserIdByUserName(userName)
					.thenCompose(this :: getUserDetailsByUserId)
					.thenCompose(this :: getUserAddressByUserDetails);
			
			System.out.println(profileFuture.join());
		}
		
		public static void main(String[] args) {
			ThenComposeScenario scenario = new ThenComposeScenario();
			scenario.getAllDetailsOfUser("Amit");
		}
}
