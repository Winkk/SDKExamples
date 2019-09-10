

#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>

NS_ASSUME_NONNULL_BEGIN

@interface WinkkProfile : NSObject

#pragma mark - Methods

/**-----------------------------------------------------------------------------
 * @name Fetching WinkkProfile instance
 * -----------------------------------------------------------------------------
 */

/**
 This fetches WinkkProfile instance.
 
 @param profileResponse ProfileResponse result.
 
 @returns the WinkkProfile instance
 */
-(id)initWithProfileResponse:(NSObject*)profileResponse;


/**-----------------------------------------------------------------------------
 * @name public WinkkProfile getters
 * -----------------------------------------------------------------------------
 */
/**
 * Getter for profile's ID.
 *
 * @return Profile's ID. OR nil
 * */
-(NSString*)getID;
/**
 * Getter for profile's name.
 *
 * @return Profile's name.
 * */
-(NSString*)getName;
/**
 * Flag showing whether profile has strong authorization type.
 *
 * @return True - if profile has strong authorization type.
 * */
-(Boolean)hasStrongAuthorization;
/**
 * Getter for profile's email.
 *
 * @return Profile's email.
 * */
-(NSString*)getEmail;
/**
 * Getter for profile's first name.
 *
 * @return Profile's first name.
 * */
-(NSString*)getFirstName;
/**
 * Getter for profile's last name.
 *
 * @return Profile's last name.
 * */
-(NSString*)getLastName;
/**
 * Getter for profile's nickname.
 *
 * @return Profile's nickname.
 * */
-(NSString*)getNickname;
/**
 * Getter for profile's country.
 *
 * @return Profile's country.
 * */
-(NSString*)getCountry;
/**
 * Getter for profile's address.
 *
 * @return Profile's address.
 * */
-(NSString*)getAddress;
/**
 * Getter for profile's phone.
 *
 * @return Profile's phone.
 * */
-(NSString*)getPhone;
/**
 * Getter for profile's avatar in raw base64 string format.
 *
 * @return Profile's avatar in base64.
 * */
-(NSString*)getRawAvatarInBase64;
/**
 * Loads profile's avatar in UIImage.
 *
 * @param maxWidth  Max width of loaded UIImage for optimization purposes.
 * @param maxHeight Max height of loaded UIImage for optimization purposes.
 *
 * @return Generated avatar UIImage or null.
 * */
-(UIImage*)getAvatarWithMaxWidth:(int)maxWidth maxHeight:(int)maxHeight;

@end

NS_ASSUME_NONNULL_END
