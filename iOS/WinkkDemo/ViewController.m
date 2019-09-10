//
//  ViewController.m
//  WinkkDemo
//
//  Created by Дмитрий Савичев on 10/09/2019.
//  Copyright © 2019 Дмитрий Савичев. All rights reserved.
//

#import "ViewController.h"
#import <WinkkSDK/Winkk.h>

@interface ViewController ()  <WinkkAuthorizationDelegate>

@end

@implementation ViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view.
}

/**
 * Start winkk SDK auth session
 * */
-(IBAction)doAuthWinkk:(id)sender {
    Winkk* winkk = [Winkk sharedManager];
    [winkk start:self];
}


/**
 * When authorization has failed for some reason.
 *
 * @param reason Authorization failure reason.
 * */
-(void)onWinkkAuthorizationFailed:(NSUInteger)reason {
    NSArray* enumText = @[
                          @"NO_WINKK_PASS_APP_INSTALLED",
                          @"SDK_WAS_NOT_INITIALIZED",
                          @"ANOTHER_AUTHORIZATION_IS_IN_PROGRESS",
                          @"NO_CONNECTION_TO_WINKK_SERVER",
                          @"SDK_UPDATE_REQUIRED",
                          @"WINKK_SERVER_IS_ON_MAINTENANCE",
                          @"UNKNOWN_SERVER_ERROR"
                          ];
    
    NSString* errorString = @"UNKNOWN_SERVER_ERROR";
    if ([enumText count] > reason) {
        errorString = [enumText objectAtIndex:reason];
    }
    self.textOut.text = errorString;
}


/**
 * When authorization has been successfully completed.
 *
 * @param profile Obtained profile data.
 * */
-(void)onWinkkAuthorizationSucceeded:(WinkkProfile*)profile {
    
    // Setting avatar if it is present in profile.
    UIImage* avatarImage = [profile getAvatarWithMaxWidth:100 maxHeight:100];
    [self.avatar setImage:avatarImage];
    
    // create text out
    NSMutableArray* textOutArray = [[NSMutableArray alloc] init];
    
    // Name.
    if ([profile getName]) [textOutArray addObject:[NSString stringWithFormat:@"Name: %@", [profile getName]]];
    
    [textOutArray addObject:@"----------------------"];
    [textOutArray addObject:[profile hasStrongAuthorization] ? @"Has strong auth: true" : @"Has strong auth: false"];
    
    // Email.
    if ([profile getEmail]) [textOutArray addObject:[NSString stringWithFormat:@"Email: %@", [profile getEmail]]];
    
    // First name.
    if ([profile getFirstName]) [textOutArray addObject:[NSString stringWithFormat:@"First name: %@", [profile getFirstName]]];
    
    // Last name.
    if ([profile getLastName]) [textOutArray addObject:[NSString stringWithFormat:@"Last name: %@", [profile getLastName]]];
    
    // Nick name.
    if ([profile getNickname]) [textOutArray addObject:[NSString stringWithFormat:@"Nick name: %@", [profile getNickname]]];
    
    // Country.
    if ([profile getCountry]) [textOutArray addObject:[NSString stringWithFormat:@"Country: %@", [profile getCountry]]];
    
    // Address.
    if ([profile getAddress]) [textOutArray addObject:[NSString stringWithFormat:@"Address: %@", [profile getAddress]]];
    
    // Phone.
    if ([profile getPhone]) [textOutArray addObject:[NSString stringWithFormat:@"Phone: %@", [profile getPhone]]];
    
    // Rendering prepared text.
    self.textOut.text = [textOutArray componentsJoinedByString:@"\r\n"];
}
@end
