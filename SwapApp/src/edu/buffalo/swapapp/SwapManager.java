package edu.buffalo.swapapp;


public final class SwapManager {
    private LeastRecentlyUsed policy;
    
    public SwapManager() {
        policy = new LeastRecentlyUsed();
    }
}
