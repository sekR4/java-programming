def encrypt_message(message: str, key: int = 17):
    """Encrypts/reverses each letter in a message.

    Parameters
    ----------
    message : str
        Text input
    key : int, optional
        A key to determine the shift of the alphabet, by default 17

    Returns
    -------
    str
        Encrypted message
    """

    alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    shifted_alphabet = alphabet[key:] + alphabet[:key]
    encrypted_message = ""

    for i in message.upper():

        # Use encryption for letters only, keep the rest
        if i in alphabet:

            # Find index in alphabet
            for idx, l in enumerate(alphabet):
                if i == l:

                    # Add letter in shifted alphabet
                    # with this index to the message
                    encrypted_message += shifted_alphabet[idx]
        else:
            encrypted_message += i

    return encrypted_message


assert encrypt_message("I AM", 17) == "Z RD"
assert encrypt_message("A BAT", 19) == "T UTM"

print(encrypt_message("A house can't be green. Right?", 19))

key = 19
encrypted = encrypt_message("A house can't be green. Right?", key)
print(encrypt_message(encrypted, 26 - key))

