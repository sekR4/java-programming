def reverse(s):
    # NOTE: reversing strings in python can be done easier
    # here I am just playing through the java loop example
    ret = ""
    for k in range(len(s)):
        ret = s[k] + ret
    return ret


print(reverse("fun"))
