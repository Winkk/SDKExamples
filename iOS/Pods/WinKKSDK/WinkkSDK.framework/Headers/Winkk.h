

#import <Foundation/Foundation.h>

#import "WinkkProfile.h"

NS_ASSUME_NONNULL_BEGIN

#pragma mark - Delegate

/**-----------------------------------------------------------------------------
 * @name Winkk SDK Delegate to notify about Winkk authorization.
 * -----------------------------------------------------------------------------
 */
@protocol WinkkAuthorizationDelegate <NSObject>

/**
 * When authorization has failed for some reason.
 *
 * @param reason Authorization failure reason.
 * */
-(void)onWinkkAuthorizationFailed:(NSUInteger)reason;


/**
 * When authorization has been successfully completed.
 *
 * @param profile Obtained profile data.
 * */
-(void)onWinkkAuthorizationSucceeded:(WinkkProfile*)profile;

@end


@interface Winkk : NSObject

#pragma mark - Consts



#pragma mark - Properties

/**-----------------------------------------------------------------------------
 * @name Instance Properties
 * -----------------------------------------------------------------------------
 */



#pragma mark - Methods

/**-----------------------------------------------------------------------------
 * @name Fetching Winkk SDK instance
 * -----------------------------------------------------------------------------
 */

/**
 This fetches the default SDK instance.
 
 @returns the default Winkk SDK instance
 */

+(id)sharedManager;




/**-----------------------------------------------------------------------------
 * @name Initialize the Winkk SDK with your ApplicationID
 * -----------------------------------------------------------------------------
 */

/**
 Initializes the WInkk instance with your ApplicationID
 
 We recommend you first initialize your class within your "didFinishLaunchingWithOptions" method inside your app delegate.
 
 **Note:** Any other methods will not work until its' correct initialization.
 
 @param applicationID of the application registered to be used with SDK, without "#" sign.
 */
+(void)initialize:(NSString*)applicationID;


/**-----------------------------------------------------------------------------
 * @name Winkk SDK methods
 * -----------------------------------------------------------------------------
 */

/**
 * Checks current build mode.
 *
 * @return True if the library has been built in the debug mode.
 * */
-(Boolean)isDebug;

/**
 Set debug mode for lib.
 */
-(void)setDebugMode:(Boolean)value;


/**-----------------------------------------------------------------------------
 * @name Starts Winkk-based authorization session
 * -----------------------------------------------------------------------------
 */

/**
 Starts Winkk-based authorization session.
 
 @param delegate Notifies about results.
 */

-(void)start:(id<WinkkAuthorizationDelegate>)delegate;
@end

NS_ASSUME_NONNULL_END
