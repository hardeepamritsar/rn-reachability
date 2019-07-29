
#import "RNInternetReachability.h"
#import "Reachability.h"

@implementation RNInternetReachability

- (dispatch_queue_t)methodQueue
{
    return dispatch_get_main_queue();
}
RCT_EXPORT_MODULE()


RCT_EXPORT_METHOD(isReachable: (NSInteger *)timeout domain:(NSString*)domain resolver:(RCTPromiseResolveBlock)resolve rejecter:(RCTPromiseRejectBlock)reject)
{
    NetworkStatus status = [[Reachability reachabilityWithHostName:domain] currentReachabilityStatus];
    resolve(@(status == ReachableViaWiFi || status == ReachableViaWWAN ? true : false));
}

@end
  
